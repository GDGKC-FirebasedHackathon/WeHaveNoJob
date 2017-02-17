//
//  ViewController.swift
//  WeHaveNoJob-iOS
//
//  Created by   minjae on 2017. 2. 17..
//  Copyright © 2017년   minjae. All rights reserved.
//

import UIKit
import Firebase

class ClassTableViewController: UITableViewController {
    // enum
    enum Section: Int {
        case createNewChannelSection = 0
        case currentChannelsSection
    }
    
    var senderDisplayName: String? // 앞 뷰인 auth에서 날라온 익명 붙여짐
    var newChannelTextField: UITextField? // 새로운 텍스트 필드 생성
    private var channels: [Channel] = [] // 채널을 담는 배열

    private lazy var channelRef: FIRDatabaseReference = FIRDatabase.database().reference().child("channels")// will be used to store a reference to the list of channels in the database
    private var channelRefHandle: FIRDatabaseHandle?// will hold a handle to the reference so you can remove it later on

    override func viewDidLoad() {
        super.viewDidLoad()
        title = "Class"
        observeChannels()
        
    }
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        
        channels.append(Channel(id: "lecture1", name: "lecture1"))
        channels.append(Channel(id: "lecture2", name: "lecture2"))
        channels.append(Channel(id: "lecture3", name: "lecture3"))
        self.tableView.reloadData()
    }
    
    deinit {
        if let refHandle = channelRefHandle {
            channelRef.removeObserver(withHandle: refHandle)
        }
    }
    
    // MARK: Navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        super.prepare(for: segue, sender: sender)
        
        if let channel = sender as? Channel {
            let chatVc = segue.destination as! ChatViewController
        
            chatVc.senderDisplayName = senderDisplayName
            chatVc.channel = channel
            chatVc.channelRef = channelRef.child(channel.id)
        }
    }
    
    // MARK: Firebase related methods
    private func observeChannels() {
        // Use the observe method to listen for new
        // channels being written to the Firebase DB
        channelRefHandle = channelRef.observe(.childAdded, with: { (snapshot) -> Void in
            let channelData = snapshot.value as! Dictionary<String, AnyObject>
            let id = snapshot.key
            if let name = channelData["className"] as! String!, name.characters.count > 0 {
                self.channels.append(Channel(id: id, name: name))
                self.tableView.reloadData()
            } else {
                print("Error! Could not decode channel data")
            }
        })
    }
    
    // MARK: UITableViewDelegate
    
    override func numberOfSections(in tableView: UITableView) -> Int {
        return 2
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        if let currentSection: Section = Section(rawValue: section) {
            switch currentSection {
            case .createNewChannelSection:
                return 1
            case .currentChannelsSection:
                return channels.count
            }
        } else {
            return 0
        }
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let reuseIdentifier = (indexPath as NSIndexPath).section == Section.createNewChannelSection.rawValue ? "NewChannel" : "ExistingChannel"
        let cell = tableView.dequeueReusableCell(withIdentifier: reuseIdentifier, for: indexPath)
        
        if (indexPath as NSIndexPath).section == Section.createNewChannelSection.rawValue {
            if let createNewChannelCell = cell as? CreateChannelCell {
                newChannelTextField = createNewChannelCell.newChannelNameField
            }
        }
        else if (indexPath as NSIndexPath).section == Section.currentChannelsSection.rawValue {
            cell.textLabel?.text = channels[(indexPath as NSIndexPath).row].name
        }
        return cell
    }
    
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        if indexPath.section == Section.currentChannelsSection.rawValue {
            let channel = channels[(indexPath as NSIndexPath).row]
            self.performSegue(withIdentifier: "ShowChannel", sender: channel)
        }
    }
    
    // make class Channel
    @IBAction func createChannel(_ sender: Any) {
        if let name = newChannelTextField?.text {
            let newChannelRef = channelRef.childByAutoId()
            let channelItem = [ 
                "className": name
            ]
            newChannelRef.setValue(channelItem)
        }
    }
    
}

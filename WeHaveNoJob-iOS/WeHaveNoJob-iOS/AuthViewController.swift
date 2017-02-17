//
//  ViewController.swift
//  WeHaveNoJob-iOS
//
//  Created by   minjae on 2017. 2. 17..
//  Copyright © 2017년   minjae. All rights reserved.
//

import UIKit
import Firebase
import FirebaseAuth


class AuthViewController: UIViewController {
    //방 번호
    @IBOutlet weak var classNumber: UITextField!
    // 익명
    @IBOutlet weak var anonymousName: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    // MARK: Navigation
    // classTableViewController에 익명을 보내주기
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        super.prepare(for: segue, sender: sender)
        let navVc = segue.destination as! UINavigationController
        let channelVc = navVc.viewControllers.first as! ClassTableViewController
        
        channelVc.senderDisplayName = anonymousName.text
    }
    //Firebase 인증
    @IBAction func anonButton(_ sender: Any) {
        let password: String = "123456"
        if anonymousName.text != "" {
            FIRAuth.auth()?.signInAnonymously(){ (user, error) in if error != nil {
                    print(error!)
                    return
                }
                print("User logged in Anonymously       with uid : " + (user?.uid)!)
                // ...
            }
        }
        else {print("이름이 없습니다.")}
        if classNumber.text != nil {
            if password == classNumber.text {
                self.performSegue(withIdentifier: "LoginToChat", sender: nil)
            }
        }
        else {print("비번이 없습니다.")}
        
    }
    //Firebase 익명 signout
    @IBAction func signOut(_ sender: Any) {
        print("signOut")
            try! FIRAuth.auth()?.signOut()
    }



}


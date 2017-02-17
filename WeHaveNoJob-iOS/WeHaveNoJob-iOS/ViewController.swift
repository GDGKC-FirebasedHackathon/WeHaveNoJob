//
//  ViewController.swift
//  WeHaveNoJob-iOS
//
//  Created by   minjae on 2017. 2. 17..
//  Copyright © 2017년   minjae. All rights reserved.
//

import UIKit
import FacebookLogin

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        
        let loginButton = LoginButton(readPermissions: [ .publicProfile ])
        loginButton.center = view.center
        
        view.addSubview(loginButton)
        loginButton = LoginButton(readPermissions: [ .PublicProfile, .Email, .UserFriends ])
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}


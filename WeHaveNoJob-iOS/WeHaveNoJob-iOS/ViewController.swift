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


class ViewController: UIViewController {


    
    override func viewDidLoad() {
        super.viewDidLoad()

    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    @IBAction func anonButton(_ sender: Any) {

        FIRAuth.auth()?.signInAnonymously(){ (user, error) in if error != nil {
            print(error!)
            }
            print("User logged in Anonymously with uid : " + (user?.uid)!)
            // ...
        }
    }

    @IBAction func signOut(_ sender: Any) {
        print("signOut")
        try! FIRAuth.auth()?.signOut()
    }


}


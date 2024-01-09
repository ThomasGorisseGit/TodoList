import { UserCredentials } from 'src/app/interfaces/user-credentials';
import { AuthService } from './../../services/auth.service';
import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  formGroup : FormGroup = new FormGroup({
    username : new FormControl(),
    password : new FormControl(),
  })

  constructor(private authService:AuthService){
    console.log(
      );
  }


  connect(){
    var userDetails : UserCredentials = {
      username:this.formGroup.controls["username"].value,
      password:this.formGroup.controls["password"].value
    };

    this.authService.login(userDetails);
  }

}

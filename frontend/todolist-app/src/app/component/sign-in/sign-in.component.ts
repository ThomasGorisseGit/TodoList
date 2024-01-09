import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { User } from 'src/app/interfaces/user';
import { AuthService } from 'src/app/services/auth.service';


@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent {

  formGroup : FormGroup = new FormGroup({
    username : new FormControl(),
    password : new FormControl(),
  })

  constructor(private authService:AuthService){
    console.log(
      );
  }


  connect(){
    var userDetails : User = {
      username:this.formGroup.controls["username"].value,
      password:this.formGroup.controls["password"].value,
      firstName:this.formGroup.controls["firstName"].value,
      lastName:this.formGroup.controls["lastName"].value,
      phone:this.formGroup.controls["phone"].value,
      email:this.formGroup.controls["email"].value
    };

    this.authService.login(userDetails);
  }

}

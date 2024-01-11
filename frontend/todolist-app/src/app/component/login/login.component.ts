import { UserCredentials } from 'src/app/interfaces/user-credentials';
import { AuthService } from './../../services/auth.service';
import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  formGroup : FormGroup = new FormGroup({
    username : new FormControl('',Validators.required),
    password : new FormControl('',Validators.required),
  })

  constructor(private authService:AuthService){

  }

  validateForm(){

    Object.keys(this.formGroup.controls).forEach(controlName => {
      const control = this.formGroup.get(controlName) as FormControl;
      control?.markAsTouched();
      control?.updateValueAndValidity();

    });
  }

  connect(){
    var userDetails : UserCredentials = this.formGroup.value;
    this.validateForm();
    if(this.formGroup.valid){
      this.authService.login(userDetails);
    }
  }

  getFormControl(name:string) : FormControl{
    return this.formGroup.get(name) as FormControl;
  }
}

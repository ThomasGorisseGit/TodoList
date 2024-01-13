import { Component, OnInit} from '@angular/core';
import { Form, FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from 'src/app/interfaces/user';
import { AuthService } from 'src/app/services/auth.service';




@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent {

  formGroup : FormGroup = new FormGroup({
    username : new FormControl('',[Validators.required]),
    password : new FormControl('',[Validators.required]),
    firstName : new FormControl('',[Validators.required]),
    lastName : new FormControl('',[Validators.required]),
    phone : new FormControl('',[Validators.pattern(/^\d{10}$/), Validators.required]),
    email : new FormControl('',[Validators.required,Validators.email]),

  })

  public valid : boolean = true;


  constructor(private authService:AuthService){}

  validateForm(){

    Object.keys(this.formGroup.controls).forEach(controlName => {
      const control = this.formGroup.get(controlName) as FormControl; // Cast AbstractControl to FormControl
      control?.markAsTouched();
      control?.updateValueAndValidity();
    });
  }
  getFormControl(name:string) : FormControl{
    return this.formGroup.get(name) as FormControl;
  }

  register(){

    var user : User = this.formGroup.value;
    this.validateForm();

    //if a user attribute is null
    if (this.formGroup.valid) {
      this.authService.register(user);
    }

  }

  toCloseFromChild(isValid: boolean) {
    this.valid = isValid;
  }

}

import { Component, OnInit} from '@angular/core';
import { Form, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
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

  public valid : boolean = false; //mettre a false

  private username : string = '';

  validationCode : FormControl = new FormControl('',[Validators.required,Validators.pattern(/^\d{6}$/)]);


  constructor(private authService:AuthService, private router:Router){
    this.validCode();
  }

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
      this.authService.register(user).subscribe({
        next:(val:User) =>
        {
          this.username =  val.username
          this.valid = true;

        }

    })

  }
}

  toCloseFromChild(isValid: boolean) {
    this.valid = isValid;
  }

  validCode(){
    this.validationCode.valueChanges.subscribe((value)=>{
      if(value.length == 6){
        //todo ajouter une barre de chargement

        this.authService.validCode(value,this.username).subscribe({
          next : (data) => { console.log(data) }

      })
    }
    })

  }
  goto(location:string){
    this.router.navigateByUrl(location);
  }

}

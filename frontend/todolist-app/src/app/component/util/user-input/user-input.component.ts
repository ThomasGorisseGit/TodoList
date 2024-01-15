import { Component, Input } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-user-input',
  styleUrls: ['./user-input.component.css'],
  template: `
      <div class="default_form-field">
        <label class="default_label" [for]="name">{{ label }}</label>
        <div class="input-image">
          <input class="default_input" maxlength={{inputLength}} type={{type}} placeholder={{placeholder}} [id]="name" [formControl]="controle" />
          <img *ngIf="rightImage !== null" src={{rightImage}} alt={{rightImage}}>
        </div>
        <div class="error" *ngIf="controle.touched && controle.invalid ">
          {{ errorMessage }}
        </div>
    </div>
  `
})
export class UserInputComponent {
  @Input() label!: string;
  @Input() name!: string;
  @Input() controle!: FormControl;
  @Input() errorMessage!: String;
  @Input() rightImage? : String | null =null;
  @Input() type: String = "text";
  @Input() placeholder! : String ;
  @Input() inputLength! : number;
}

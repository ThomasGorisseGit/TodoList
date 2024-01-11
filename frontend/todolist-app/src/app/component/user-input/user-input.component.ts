import { Component, Input } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-user-input',
  styleUrls: ['./user-input.component.css'],
  template: `
      <div class="default_form-field">
        <label class="default_label" [for]="name">{{ label }}</label>
        <input class="default_input" type="text" [id]="name" [formControl]="controle" />
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
}

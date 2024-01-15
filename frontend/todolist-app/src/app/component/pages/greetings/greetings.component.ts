import { Component, ElementRef, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-greetings',
  templateUrl: './greetings.component.html',
  styleUrls: ['./greetings.component.css']
})
export class GreetingsComponent {

  constructor(private router : Router) {}

  public goto(location:string){
    this.router.navigateByUrl(location);
  }

}

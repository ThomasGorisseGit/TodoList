import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lower-navbar',
  templateUrl: './lower-navbar.component.html',
  styleUrls: ['./lower-navbar.component.css']
})
export class LowerNavbarComponent {
  
  constructor(private router : Router) {}

  public goto(location:string){
    this.router.navigateByUrl(location);
  }
}

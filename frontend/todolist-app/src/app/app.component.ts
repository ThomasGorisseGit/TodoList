import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  authRoutes:string[]= [
    "/login",
    "/sign-in",
    "/"
  ]

  currentRoute:string;
  title = 'todolist-app';

  constructor(){
    this.currentRoute = window.location.pathname;
  }
  ngOnInit(): void {

  }
}

import { NgModule, inject } from '@angular/core';
import { Router, RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { SignInComponent } from './component/sign-in/sign-in.component';
import { GreetingsComponent } from './component/greetings/greetings.component';


const routes: Routes = [
  { path: 'login',component: LoginComponent },
  {path: 'sign-in',component : SignInComponent},
  { path: '',component: GreetingsComponent, pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

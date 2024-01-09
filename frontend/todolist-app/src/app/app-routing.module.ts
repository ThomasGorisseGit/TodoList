import { NgModule, inject } from '@angular/core';
import { Router, RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { SignInComponent } from './component/sign-in/sign-in.component';


const routes: Routes = [
  { path: 'login',component: LoginComponent },
  {path: 'signIn',component : SignInComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

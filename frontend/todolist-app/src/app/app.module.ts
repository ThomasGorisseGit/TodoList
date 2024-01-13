import {MatInputModule} from '@angular/material/input';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LowerNavbarComponent } from './component/navbar/lower-navbar/lower-navbar.component';
import { LoginComponent } from './component/login/login.component';
import { RouterLink, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UpperNavbarComponent } from './component/navbar/upper-navbar/upper-navbar.component';
import { SignInComponent } from './component/sign-in/sign-in.component';
import { ReactiveFormsModule } from '@angular/forms';
import { AuthInterceptor } from './services/auth.interceptor';
import { UserInputComponent } from './component/user-input/user-input.component';
import { PopUpComponent } from './component/pop-up/pop-up.component';
import { BurgerMenuComponent } from './component/navbar/burger-menu/burger-menu.component';
@NgModule({
  declarations: [
    AppComponent,
    LowerNavbarComponent,
    LoginComponent,
    UpperNavbarComponent,
    SignInComponent,
    UserInputComponent,
    PopUpComponent,
    BurgerMenuComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterOutlet,
    RouterLink,
    CommonModule,
    BrowserAnimationsModule,
    MatInputModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    {
      provide:HTTP_INTERCEPTORS,
      useClass:AuthInterceptor,
      multi:true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

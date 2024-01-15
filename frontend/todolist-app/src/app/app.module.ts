import {MatInputModule} from '@angular/material/input';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LowerNavbarComponent } from './component/util/navbar/lower-navbar/lower-navbar.component';
import { LoginComponent } from './component/pages/login/login.component';
import { RouterLink, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UpperNavbarComponent } from './component/util/navbar/upper-navbar/upper-navbar.component';
import { SignInComponent } from './component/pages/sign-in/sign-in.component';
import { ReactiveFormsModule } from '@angular/forms';
import { AuthInterceptor } from './services/auth.interceptor';
import { UserInputComponent } from './component/util/user-input/user-input.component';
import { PopUpComponent } from './component/util/pop-up/pop-up.component';
import { BurgerMenuComponent } from './component/util/navbar/burger-menu/burger-menu.component';
import { GreetingsComponent } from './component/pages/greetings/greetings.component';
@NgModule({
  declarations: [
    AppComponent,
    LowerNavbarComponent,
    LoginComponent,
    UpperNavbarComponent,
    SignInComponent,
    UserInputComponent,
    PopUpComponent,
    BurgerMenuComponent,
    GreetingsComponent
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

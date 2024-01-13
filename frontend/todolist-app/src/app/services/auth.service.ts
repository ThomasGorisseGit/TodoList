import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { apiUrl } from '../interfaces/api-url';
import { UserCredentials } from '../interfaces/user-credentials';
import { Observable } from 'rxjs';
import { HttpError } from 'http-errors';
import { User } from '../interfaces/user';
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http:HttpClient) { }

  public register(
    user:User
  ){
    return this.http.post(apiUrl+"/auth/register",user).subscribe({
      next:(val:any)=> console.log(val)

    })
  }

  public login(
    usernamePassword:UserCredentials
  ){

    this.http.post(apiUrl+"/auth/connect",usernamePassword).subscribe({
      next:(val:any) => {
        localStorage.setItem("jwt",JSON.stringify(val))
        // TODO : FeedBack ; vous êtes connecté
      },
      error:(err:HttpError) => {
        // TODO : FeedBack ; une erreur est survenue :
        // -Soit erreur d'identifiants
        // -Soit erreur du serveur
      }
    })
  }
}

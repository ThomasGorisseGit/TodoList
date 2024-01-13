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

  ):Observable<User>
  {
    return this.http.post(apiUrl+"/auth/register",user) as Observable<User>

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

public validCode(
  code : string,
  username : string
){
  return this.http.post(apiUrl+"/auth/activate?activationCode="+code+"&username="+username,username).pipe(
    (request) => {
      request.subscribe({
        next:(token:any) => {
          localStorage.setItem("jwt",JSON.stringify(token))
          // TODO : FeedBack ; vous êtes connecté
        },
    })
    return request;
  }
  )
}
}

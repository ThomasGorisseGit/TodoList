import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { apiUrl } from '../interfaces/api-url';
import { UserCredentials } from '../interfaces/user-credentials';
import { Observable } from 'rxjs';
import { HttpError } from 'http-errors';
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http:HttpClient) { }

  public login(
    usernamePassword:UserCredentials
  ){
    this.http.post(apiUrl+"/auth/connect",usernamePassword).subscribe({
      next:(val:any) => {sessionStorage.setItem("jwt",val.bearer)},
      error:(err:HttpError)=>{}
    })
  }
}

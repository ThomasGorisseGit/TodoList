import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { apiUrl } from '../interfaces/api-url';
import { UserCredentials } from '../interfaces/user-credentials';
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http:HttpClient) { }

  public login(
    // user info
    userInfo:UserCredentials
  ){
    return this.http.post(apiUrl+"/auth/connect",userInfo);
  }
}

import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {

    var jwt : {bearer:string} = JSON.parse(localStorage.getItem("jwt") as string) ;
    // jwt == null -> null + "null"
    // jwt === null -> null
    if(jwt != null){
      request = request.clone({
        setHeaders:{
          Authorization: `Bearer ${jwt.bearer}`
        }
      })

    }
    return next.handle(request);
  }
}

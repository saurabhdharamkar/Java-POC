import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class UserService {

  private baseUrl = 'http://localhost:8080/user';

  constructor(private http:HttpClient) { }

  getUserList():Observable<any> {
    return this.http.get(`${this.baseUrl}`+'/getAllUsers');
  }

  createUser(user: object):Observable<object> {
    return this.http.post(`${this.baseUrl}`+'/addUser', user);
  }

  deleteUser(userId: number):Observable<any> {
    return this.http.delete(`${this.baseUrl}/deleteUser/${userId}`, { responseType: 'text' });
  }


  getUser(userId: number):Observable<any> {
    return this.http.get(`${this.baseUrl}/getUserById/${userId}`);
  }
  getByFirstName(firstName: string):Observable<any> {
    return this.http.get(`${this.baseUrl}/getByFirstName/${firstName}`);
  }
  sortByDob():Observable<any> {
    return this.http.get(`${this.baseUrl}/sortByDob`);
  }
  sortByDoj():Observable<any> {
    return this.http.get(`${this.baseUrl}/sortByDoj`);
  }

  sortByFirstName():Observable<any> {
    return this.http.get(`${this.baseUrl}/sortByFirstName`);
  }

  updateUser(userId: number, value: any):Observable<any>{
    return this.http.put(`${this.baseUrl}/updateUser/${userId}`, value);
  }
  
}                                           
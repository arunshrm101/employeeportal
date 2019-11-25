import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {

  private employeeUrl: string;

  constructor(private http: HttpClient) {
    this.employeeUrl = 'http://localhost:8080/employee';
   }


   public findAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.employeeUrl);
  }
 
  public save(employee: Employee) {
    console.log(employee);
    
    return this.http.post<Employee>(this.employeeUrl, employee);
  }
}

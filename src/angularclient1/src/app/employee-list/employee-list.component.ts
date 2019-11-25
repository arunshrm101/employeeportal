import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeServiceService } from '../employee-service.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})


export class EmployeeListComponent implements OnInit {
  employees=[];


  constructor(private employeeService: EmployeeServiceService) {
  }

  ngOnInit() {
    this.employeeService.findAll().subscribe(data => {
      console.log(data);
      
      this.employees = data;
    });
  }

}

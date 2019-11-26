import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeServiceService } from '../employee-service.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})


export class EmployeeListComponent implements OnInit {
  employees = [];

  constructor(private employeeService: EmployeeServiceService) {
    this.employeeService.findAll().subscribe(data => {
      console.log(data);
      this.employees = data.sort(function (a, b) {
        var nameA = a.firstName.toLowerCase(), nameB = b.firstName.toLowerCase()
        if (nameA < nameB)
          return -1
        if (nameA > nameB)
          return 1
        return 0
      });
    });
  }

  ngOnInit() {
  }
}

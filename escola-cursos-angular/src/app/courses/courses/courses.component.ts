import { Component } from '@angular/core';
import {Course} from "../model/course";
import {CoursesService} from "../services/courses.service";
import {catchError, Observable, of} from "rxjs";

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent {
  courses$: Observable<Course[]>;
  displayedColumns = ['name', 'category'];
  loading: any;

  constructor(private coursesService: CoursesService) {
    this.courses$ = this.coursesService.list()
      .pipe(
        catchError(error => {
          console.log(error)
          return of([])
        })
      );

  }


}

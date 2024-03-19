import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {CoursesRoutingModule} from './courses-routing.module';
import {CoursesComponent} from './containers/courses/courses.component';

import {SharedModule} from "../shared/shared.module";
import {CourseFormComponent} from './containers/course-form/course-form.component';
import {ReactiveFormsModule} from "@angular/forms";
import {CoursesListComponent} from "./components/courses-list/courses-list.component";

@NgModule({
    imports: [
    CommonModule,
    CoursesRoutingModule,
    SharedModule,
    ReactiveFormsModule
    // CoursesListComponent removed from here since it's a component, not a module
    ,
    CoursesComponent,
    CourseFormComponent,
    CoursesListComponent // Components are declared here
]
})
export class CoursesModule {
}

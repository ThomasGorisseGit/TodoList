import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-upper-navbar',
  templateUrl: './upper-navbar.component.html',
  styleUrls: ['./upper-navbar.component.css']
})
export class UpperNavbarComponent {

  @Input() listName! : string
  @Input() listIcon! : string
  @Input() isList : boolean = false
}

import { Component, Input,EventEmitter, Output  } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-pop-up',
  templateUrl: './pop-up.component.html',
  styleUrls: ['./pop-up.component.css']
})
export class PopUpComponent {

  @Input()
  public title: string = '';
  @Input()
  public message: string = '';
  @Input()
  public input?: FormControl | null;
  @Input()
  public quit : boolean = false;
  @Input()
  public timer : number = 0;
  @Input()
  public errorMessage : string = '';


  @Output()
  closeEmitter: EventEmitter<boolean> = new EventEmitter<boolean>();

  constructor() {  }

    public closePopUp(): void {
      if(this.quit)
      {
        this.closeEmitter.emit(false);
      }
    }

    public inPopUp(event : Event): void {
      event.stopPropagation();
      console.log(event);
    }

    public openPopUp(): void {
    }


}

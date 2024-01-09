import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpperNavbarComponent } from './upper-navbar.component';

describe('UpperNavbarComponent', () => {
  let component: UpperNavbarComponent;
  let fixture: ComponentFixture<UpperNavbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpperNavbarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpperNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

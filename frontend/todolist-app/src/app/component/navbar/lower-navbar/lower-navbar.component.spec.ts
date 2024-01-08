import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LowerNavbarComponent } from './lower-navbar.component';

describe('LowerNavbarComponent', () => {
  let component: LowerNavbarComponent;
  let fixture: ComponentFixture<LowerNavbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LowerNavbarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LowerNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

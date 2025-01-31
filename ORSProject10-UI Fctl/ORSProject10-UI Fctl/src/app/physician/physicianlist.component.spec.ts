import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PhysicianlistComponent } from './physicianlist.component';

describe('PhysicianlistComponent', () => {
  let component: PhysicianlistComponent;
  let fixture: ComponentFixture<PhysicianlistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PhysicianlistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PhysicianlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

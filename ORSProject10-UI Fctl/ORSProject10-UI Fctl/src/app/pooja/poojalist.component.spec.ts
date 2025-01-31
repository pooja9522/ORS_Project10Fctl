import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PoojalistComponent } from './poojalist.component';

describe('PoojalistComponent', () => {
  let component: PoojalistComponent;
  let fixture: ComponentFixture<PoojalistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PoojalistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PoojalistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { Component, OnInit } from '@angular/core';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-purchaselist',
  templateUrl: './purchaselist.component.html',
  styleUrls: ['./purchaselist.component.css']
})
export class PurchaselistComponent extends BaseListCtl implements OnInit {
  myKey = "";
  
  errorMessageDouble: string = '';

  public form = {
    error: false,
    message: null,
    preload: [],
    data: { id: null },
    inputerror: {},
    searchParams: {},
    searchMessage: null,
    list: [],
    pageNo: 0
  };

  base64Data: any;
  retrieveResonse: any;
  message: string;
  errorMessagetotalCost: string;

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.PURCHASE, locator, route);
  }


  validateDouble(event: KeyboardEvent): void {
    const inputValue = (event.target as HTMLInputElement).value;
    const inputChar = event.key;
    
    // Regex to match numbers with at most one decimal point
    const doublePattern = /^[0-9]*\.?[0-9]*$/;
  
    // Prevent multiple decimal points
    if (inputChar === '.' && inputValue.includes('.')) {
      event.preventDefault();
      this.errorMessageDouble = 'Only one decimal point is allowed.';
      return;
    }
  
    // Allow digits and one decimal point
    if (!doublePattern.test(inputValue + inputChar) && !['Backspace', 'Delete', 'Tab'].includes(inputChar)) {
      event.preventDefault();
      this.errorMessageDouble = 'Only numeric values with one decimal point are allowed.';
      return;
    }
  
    // Check if input exceeds max length (8 characters)
    if (inputValue.length >= 8 && !['Backspace', 'Delete', 'Tab'].includes(inputChar)) {
      event.preventDefault();
      this.errorMessageDouble = 'Input cannot exceed 8 characters.';
      return;
    }
  
    // Clear error message if valid
    this.errorMessageDouble = '';
  }

 
}






























































































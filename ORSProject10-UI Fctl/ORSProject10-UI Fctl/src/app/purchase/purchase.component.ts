import { Component } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ActivatedRoute } from '@angular/router';
import { ServiceLocatorService } from '../service-locator.service';

@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css']
})

export class PurchaseComponent extends BaseCtl {
  errorMessageTitle: string = '';
  errorMessageName: string = '';
  errorMessageDouble: string = '';




  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.PURCHASE, locator, route);
  }

  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    
    flag = flag && validator.isNotNullObject(form.orderDate);
   
    flag = flag && validator.isNotNullObject(form.product);
    
    flag = flag && validator.isNotNullObject(form.totalQuantity);
    flag = flag && validator.isNotNullObject(form.totalCost);
    
    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    form.name = data.name;
    form.orderDate = data.orderDate;
      form.product = data.product;
    form.description = data.description;
    form.totalQuantity = data.totalQuantity;
    form.totalCost = data.totalCost;
    
  }

  validateName(event: KeyboardEvent): void {
    const inputValue = (event.target as HTMLInputElement).value;
    const inputChar = event.key;
    const alphabetPattern = /^[a-zA-Z]*$/;  // Pattern to match only alphabetic characters

    if (!alphabetPattern.test(inputChar) && !['Backspace', 'Delete', 'Tab'].includes(inputChar)) {
      event.preventDefault();
      this.errorMessageName = 'Only alphabets are allowed.';
      return;
    }

    if (inputValue.length < 3) {
      this.errorMessageName = 'name must be at least 3 characters .';
    } else if (inputValue.length > 15) {
      this.errorMessageName = 'name must contain only 15 character.';
    } else {
      this.errorMessageName = '';  // Clear error message if valid
    }
  }

  validateAlphabetInput(event) {
    const charCode = event.which || event.keyCode;
    const charStr = String.fromCharCode(charCode);

    // Regular expression to test if the character is a letter
    if (!/^[a-zA-Z]+$/.test(charStr)) {
      event.preventDefault();
    }
  }



  validatePhone(event: KeyboardEvent) {
    const input = event.key;
    // Check if the input is a number or backspace
    if ((isNaN(Number(input)) && input !== 'Backspace') || (input === ' ')) {
      event.preventDefault();
    }
    // Limit the input to 10 characters
    if (this.form.data.phone && this.form.data.phone.length >= 10 && input !== 'Backspace') {
      event.preventDefault();
    }
  }

  parseDate(dateString: string): Date {
    if (dateString) {
      return new Date(dateString);
    }
    return null;
  }
  test() {

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





































































































































































































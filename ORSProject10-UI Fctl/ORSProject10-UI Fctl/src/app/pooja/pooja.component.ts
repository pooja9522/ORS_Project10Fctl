import { Component } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ActivatedRoute } from '@angular/router';
import { ServiceLocatorService } from '../service-locator.service';

@Component({
  selector: 'app-pooja',
  templateUrl: './pooja.component.html',
  styleUrls: ['./pooja.component.css']
})

export class PoojaComponent extends BaseCtl {
  errorMessageTitle: string = '';
  errorMessageName: string = '';
  errorMessageCaseAvalable: string = '';




  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.POOJA, locator, route);
  }

  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.name);
    flag = flag && validator.isNotNullObject(form.birthDate);
    flag = flag && validator.isNotNullObject(form.phone);
    flag = flag && validator.isNotNullObject(form.specialization);
    flag = flag && validator.isNotNullObject(form.description);
    flag = flag && validator.isNotNullObject(form.quantity);
    flag = flag && validator.isNotNullObject(form.cashAvailable);
    flag = flag && validator.isNotNullObject(form.itemvalue);
    flag = flag && validator.isNotNullObject(form.registrationNumber);

    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    form.name = data.name;
    form.birthDate = data.birthDate;
    form.phone = data.phone;
    form.specialization = data.specialization;
    form.description = data.description;
    form.quantity = data.quantity;
    form.cashAvailable = data.cashAvailable;
    form.itemvalue = data.itemvalue;
    form.registrationNumber = data.registrationNumber;
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

 

  validateCashAvailable(event: KeyboardEvent) {
    const input = event.key;
    // Allow numbers, decimal point, and backspace
    if (!(event.ctrlKey || event.altKey || event.metaKey) && (
      (input >= '0' && input <= '9') || input === '.' || input === 'Backspace' || input === 'Delete'
    )) {
      // Allow input to proceed
    } else {
      // Prevent default action (usually a character is typed)
      event.preventDefault();
    }
  }

  // Method to handle input validation for Cash Available field
  validateCashAvailableInput(event: Event) {
    const inputElement = event.target as HTMLInputElement;
    let value = inputElement.value;

    // Remove non-numeric characters except decimal point
    value = value.replace(/[^0-9.]/g, '');

    // Remove extra decimal points
    const parts = value.split('.');
    if (parts.length > 2) {
      value = parts[0] + '.' + parts.slice(1).join('');
    }

    // Limit the value to 1,000,000,000
    const parsedValue = parseFloat(value);
    if (!isNaN(parsedValue) && parsedValue > 1000000000) {
      value = '1000000000';
    }

    // Update the input value
    inputElement.value = value;

    // Update the ngModel data
    this.form.data.cashAvailable = value;
  }

}









































































































































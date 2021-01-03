import { Component, OnInit } from '@angular/core';
import {  FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BookService } from '../Services/book.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  constructor(private bookService: BookService, private router: Router) { }
  bookForm : FormGroup
  ngOnInit(): void {
    this.initForm()
  }

  initForm(){
    this.bookForm = new FormGroup({
      title: new FormControl('', [Validators.required, Validators.minLength(4)]),
      author: new FormControl('', [Validators.required, Validators.minLength(4)]),
      price: new FormControl('', [Validators.required, Validators.min(0.1)]),
      releaseDate: new FormControl('')
    })
  }

  addBook() {
    console.log(this.bookForm.value)
    this.bookService.addBook(this.bookForm.value).subscribe(res => {
      this.bookForm.reset;
      this.router.navigate(['/books'])
    })
  }

}

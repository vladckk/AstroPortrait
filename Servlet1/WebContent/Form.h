<div>
    <div *ngIf="message" class="alert alert-danger">{{ message }}</div>
    <p class="text-center">Введите дату рождения</p>
    <form [formGroup]="submitForm" (ngSubmit)="onSubmit()" action="Servlet" method="POST">
    <div class="form-row">
        <div class="form-group col-md-4">
            <label for="day">День</label>
            <input type="text"
            class="form-control"
            id="day" 
            placeholder="День"
            formControlName="day"
            name = "day"
            >
        </div>
        <div class="form-group col-md-4">
            <label for="month">Месяц</label>
            <input type="text"
            class="form-control"
            id="month" 
            placeholder="Месяц"
            formControlName="month"
            name = "month"
            >
        </div>
        <div class="form-group col-md-4">
            <label for="year">Год</label>
            <input type="text"
            class="form-control"
            id="year" 
            placeholder="год"
            formControlName="year"
            name = "year"
            >
        </div>
    </div>
    <div *ngIf="submitForm.invalid && (month.dirty || month.touched) && (year.dirty || year.touched) && (day.dirty || day.touched)"
            class="alert alert-danger">
            Неверная дата
    </div>
        <div class="form-group">
            <button type="submit" class="btn btn-block btn-primary" [disabled]="!submitForm.valid">Отправить</button>
        </div>
    </form>
</div>
<div>
    <div *ngIf="message" class="alert alert-danger">{{ message }}</div>
    <p class="text-center">������� ���� ��������</p>
    <form [formGroup]="submitForm" (ngSubmit)="onSubmit()" action="Servlet" method="POST">
    <div class="form-row">
        <div class="form-group col-md-4">
            <label for="day">����</label>
            <input type="text"
            class="form-control"
            id="day" 
            placeholder="����"
            formControlName="day"
            name = "day"
            >
        </div>
        <div class="form-group col-md-4">
            <label for="month">�����</label>
            <input type="text"
            class="form-control"
            id="month" 
            placeholder="�����"
            formControlName="month"
            name = "month"
            >
        </div>
        <div class="form-group col-md-4">
            <label for="year">���</label>
            <input type="text"
            class="form-control"
            id="year" 
            placeholder="���"
            formControlName="year"
            name = "year"
            >
        </div>
    </div>
    <div *ngIf="submitForm.invalid && (month.dirty || month.touched) && (year.dirty || year.touched) && (day.dirty || day.touched)"
            class="alert alert-danger">
            �������� ����
    </div>
        <div class="form-group">
            <button type="submit" class="btn btn-block btn-primary" [disabled]="!submitForm.valid">���������</button>
        </div>
    </form>
</div>
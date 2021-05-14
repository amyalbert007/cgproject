package com.cg.onlineflatrental.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "FlatBooking")
public class FlatBooking {
	@Id
	private int	bookingNo;
	@Column
	private Flat flat;
	private Tenant tenantId;
	private LocalDate bookingFromDate;
	private LocalDate bookingToDate;
	public int getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}
	public Flat getFlat() {
		return flat;
	}
	public void setFlat(Flat flat) {
		this.flat = flat;
	}
	public Tenant getTenantId() {
		return tenantId;
	}
	public void setTenantId(Tenant tenantId) {
		this.tenantId = tenantId;
	}
	public LocalDate getBookingFromDate() {
		return bookingFromDate;
	}
	public void setBookingFromDate(LocalDate bookingFromDate) {
		this.bookingFromDate = bookingFromDate;
	}
	public FlatBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FlatBooking(int bookingNo, Flat flat, Tenant tenantId, LocalDate bookingFromDate, LocalDate bookingToDate) {
		super();
		this.bookingNo = bookingNo;
		this.flat = flat;
		this.tenantId = tenantId;
		this.bookingFromDate = bookingFromDate;
		this.bookingToDate = bookingToDate;
	}
	public LocalDate getBookingToDate() {
		return bookingToDate;
	}
	public void setBookingToDate(LocalDate bookingToDate) {
		this.bookingToDate = bookingToDate;
	}
	@Override
	public String toString() {
		return "FlatBooking [bookingNo=" + bookingNo + ", flat=" + flat + ", tenantId=" + tenantId
				+ ", bookingFromDate=" + bookingFromDate + ", bookingToDate=" + bookingToDate + "]";
	}

}

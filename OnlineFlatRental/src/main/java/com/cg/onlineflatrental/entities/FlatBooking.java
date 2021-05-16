package com.cg.onlineflatrental.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



/* @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOKING_NUMBER")
    private int    bookingNo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flatId")
    private Flat flat;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tenantId")
    private Tenant tenant;
    @Column(name = "BOOKING_FROM_DATE")
    private LocalDate bookingFromDate;
    @Column(name = "BOOKING_TO_DATE")
    private LocalDate bookingToDate;*/

@Entity
@Table(name = "FlatBooking")
public class FlatBooking {
	@Id
	private int	bookingNo;
	//@Column
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "flat1Id")
	private Flat flat;
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "tenant1Id")
	private Tenant tenant;
	@Column
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
	public Tenant getTenant() {
		return tenant;
	}
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
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
	public FlatBooking(int bookingNo, Flat flat, Tenant tenant, LocalDate bookingFromDate, LocalDate bookingToDate) {
		super();
		this.bookingNo = bookingNo;
		this.flat = flat;
		this.tenant = tenant;
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
		return "FlatBooking [bookingNo=" + bookingNo + ", flat=" + flat + ", tenant=" + tenant
				+ ", bookingFromDate=" + bookingFromDate + ", bookingToDate=" + bookingToDate + "]";
	}

}

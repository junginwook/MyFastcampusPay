package com.fastcampuspay.membership.adapter.out.persistence;

import java.security.PrivateKey;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "memberShip")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberShipJpaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberShipId;

	private String name;

	private String address;

	private String email;

	private boolean isValid;

	private boolean isCorp;

	public MemberShipJpaEntity(String name, String address, String email, boolean isValid, boolean isCorp) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.isValid = isValid;
		this.isCorp = isCorp;
	}

	@Override
	public String toString() {
		return "MemberShipJpaEntity{" +
				"memberShip=" + memberShipId +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", email='" + email + '\'' +
				", isValid=" + isValid +
				", isCorp=" + isCorp +
				'}';
	}
}

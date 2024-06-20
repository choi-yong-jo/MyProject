package com.cafe.api.member.service;

import com.cafe.api.member.model.Member;
import com.cafe.api.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	public List<Member> findAll() {
		List<Member> members = new ArrayList<>();
		memberRepository.findAll().forEach(e -> members.add(e));
		return members;
	}

	public Optional<Member> findById(Integer mbrNo){
		Optional<Member> member = memberRepository.findById(mbrNo);
		return member;
	}

	public List<Member> findByNm(Member member) {
		List<Member> members = memberRepository.searchMemberNm(member);
		return members.isEmpty() ? Collections.emptyList() : members.stream().toList();
	}

	@Transactional("transactionManager")
	public boolean deleteById(Integer mbrNo){
		boolean result = false;
		Optional<Member> e = memberRepository.findById(mbrNo);
		if(e.isPresent()){
			memberRepository.deleteById(mbrNo);
			result = true;
		}
		return result;
	}

	@Transactional("transactionManager")
	public Member save(Member member){
		member.setCreateDt(LocalDateTime.now());
		memberRepository.save(member);
		return member;
	}

	@Transactional("transactionManager")
	public boolean updateById(Integer mbrNo, Member member){
		boolean result = false;
		Optional<Member> e = memberRepository.findById(mbrNo);
		member.setMbrNo(Long.valueOf(mbrNo));
		if(e.isPresent()){
			memberRepository.save(member);
			result = true;
		}
		return result;
	}

}

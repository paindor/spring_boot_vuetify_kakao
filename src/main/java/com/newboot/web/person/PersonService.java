package com.newboot.web.person;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newboot.web.util.Printer;
@Service
public class PersonService {
	@Autowired private PersonRepository personRepository;
	
	// 자바의 정석 847 collect()
	public List<String> namesOfStudents() {
		// 1. 학생의 이름
		return personRepository.findByRole("student").stream()
				.map(Person::getName)
				.collect(Collectors.toList());
	}
	public Person[] streamToArray() {
		// 2. 스트림을 배열로 전환
		return personRepository.findByRole("student").stream()
				.toArray(Person[]::new);
	}
	public Map<String, Person> streamToMap() {
		// 3. 스트림을 맵으로 전환. 학생이름이 key
		return personRepository.findByRole("student").stream()
				.collect(Collectors.toMap(s->s.getName(), p->p));
	}
	public Long theNumberOfStudents() {
		// 4. 학생의 수
		return personRepository.findByRole("student").stream()
				.collect(Collectors.counting());
	}
	public Integer totalScore() {
		// 5. 학생들 총점
		return personRepository.findByRole("student").stream()
				.collect(Collectors.summingInt(Person::getScore));
	}
	public Optional<Person> topStudent(){
		// 6. 1등 학생
		return personRepository.findByRole("student").stream()
				.collect(Collectors.maxBy(Comparator.comparingInt(Person::getScore)));
	}
	public IntSummaryStatistics getStat() {
		// 7. 전체 학생 성적 통계
		return personRepository.findByRole("student").stream()
				.collect(Collectors.summarizingInt(Person::getScore));
	}
	public String nameList() {
		// 8. 전체 학생 이름
		return personRepository.findByRole("student").stream()
				.map(Person::getName)
				.collect(Collectors.joining(",","{","}"));
	}
	
	
	// 자바의정석 851 partioningBy()
	public List<Person> partioningByGender(boolean gender) {
		// 1.단순분할 (성별로 분할) 남성 true 여성 false
		return personRepository.findByRole("student").stream()
				.collect(
						Collectors
							.partitioningBy(Person::isMale))
				.get(gender);
	}
	public Long partioningCountPerGender(boolean gender) {
		// 2.단순분할 (성별 학생수)
		return personRepository.findByRole("student").stream()
				.collect(
						Collectors
							.partitioningBy(Person::isMale,
								Collectors.counting()))
				.get(gender);
	}
	public Person partioningTopPerGender(boolean gender) {
		// 3.단순분할 (성별 1등) 남성 true 여성 false
		return personRepository.findByRole("student").stream()
				.collect(Collectors.partitioningBy(
						Person::isMale,
						Collectors.collectingAndThen(
								Collectors.maxBy(
										Comparator.comparingInt(
												Person::getScore)),
												Optional::get)))
				.get(gender);
	}
	public List<Person> partioningRejectPerGender(boolean gender) {
		// 4.다중분할 (성별 불합격자, 50점이하) 남성 true 여성 false
		return personRepository.findByRole("student").stream()
				.collect(Collectors.partitioningBy(Person::isMale,
						Collectors.partitioningBy(s->s.getScore()<=50)))
				.get(gender)
				.get(true);
	}
	// 자바의정석 855 
	public Map<Integer, List<Person>> findByHak() {
		//1. 단순 그룹화(반별로 그룹화)
		 return personRepository
				.findByRole("student").stream()
				.collect(Collectors.groupingBy(Person::getBan));
	}
	public Map<Person.Level, List<Person>> groupByGrade() {
		//2. 단순그룹화(성적별로 그룹화)
		return personRepository.findByRole("student").stream()
				.collect(Collectors.groupingBy(
						s->{
							if(s.getScore()>= 80) return Person.Level.HIGH;
							else if(s.getScore()>=50)return Person.Level.MID;
							else return Person.Level.LOW;}
						));
		
	}
	public Map<Person.Level, Long> personCountByLevel() {
		//3. 단순그룹화 + 통계(성적별 학생수))
		return personRepository.findByRole("student").stream()
				.collect(Collectors.groupingBy(s->{
					if(s.getScore()>= 80) return Person.Level.HIGH;
					else if(s.getScore()>=50)return Person.Level.MID;
					else 					return Person.Level.LOW;}, 
						Collectors.counting()
				));
				
				
	}
	public Map<Integer, Map<Integer, List<Person>>> multiGrouping() {
		// 4. 다중 그룹화 (학년별, 반별)
		return personRepository.findByRole("student").stream()
				.collect(
					Collectors.groupingBy(Person::getHak, 
							Collectors.groupingBy(Person::getBan)
				));
	}
	public Map<Integer, Map<Integer, Object>> multiGroupingMax() {
		// 5. 다중 그룹화 +통계 (학년별, 반별 1등)
		return personRepository.findByRole("student").stream()
				.collect(Collectors.groupingBy(Person::getHak,
						Collectors.groupingBy(Person::getBan,
								Collectors.collectingAndThen(
								Collectors.maxBy(Comparator
										.comparingInt(Person::getScore)),
								Optional::get))));
	}
	public Map<Object, Set<Object>> multiGroupingGrade() {
		// 6. 다중그룹화 + 통계(학년별, 반별 성적그룹)
		return personRepository.findByRole("student").stream()
				.collect(Collectors.groupingBy(s-> s.getHak()+"-"+ s.getBan(),
						Collectors.mapping(s->{
							if(s.getScore()>= 80) return Person.Level.HIGH;
							else if(s.getScore()>=50)return Person.Level.MID;
							else 					return Person.Level.LOW;},
							Collectors.toSet())));
						
	}
}

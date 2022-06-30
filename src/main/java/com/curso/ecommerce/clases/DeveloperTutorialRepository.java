package com.curso.ecommerce.clases;

	import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

	@Repository
	public interface DeveloperTutorialRepository extends JpaRepository<DeveloperTutorial, Integer>{
		@Query(value ="	SELECT SUM(developer_tutorial.total)FROM developer_tutorial",nativeQuery = true)
		public int ganancias();

	}


package ua.com.specifications;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.dto.filter.ModelFilter;
import ua.com.enity.Models;

public class ModelSpecifications implements Specification<Models> {

	private final ModelFilter filter;

	private final List<Predicate> predicates = new ArrayList<>();

	private static final Pattern REG = Pattern.compile("^[0-9]+$");

	public ModelSpecifications(ModelFilter filter) {
		super();
		this.filter = filter;
		if (REG.matcher(filter.getMax()).matches()) {
			filter.setMaxValue(new Integer(filter.getMax()));
		}
		if (REG.matcher(filter.getMin()).matches()) {
			filter.setMinValue(new Integer(filter.getMin()));
		}
	}

	private void findByPrice(Root<Models> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (filter.getMaxValue() != 0) {
			predicates.add(cb.le(root.get("price"), filter.getMaxValue()));
		}
		if (filter.getMinValue() != 0) {
			predicates.add(cb.ge(root.get("price"), filter.getMinValue()));
		}
	}

	private void findByModelName(Root<Models> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!filter.getSearch().isEmpty()) {
			predicates.add(cb.like(root.get("modelName"), filter.getSearch()
					.toLowerCase() + "%"));
		}
	}

	private void findByType(Root<Models> root, CriteriaQuery<?> query) {
		if (!filter.getTypesId().isEmpty()) {
			predicates.add(root.get("goodType").in(filter.getTypesId()));
		}
	}

	private void findByGoodCountry(Root<Models> root,
			CriteriaQuery<?> query) {
		if (!filter.getColorId().isEmpty()) {
			predicates.add(root.get("color").in(filter.getColorId()));
		}
	}

	private void findByGoodGPU(Root<Models> root, CriteriaQuery<?> query) {
		if (!filter.getGpuTypesId().isEmpty()) {
			predicates.add(root.get("gpuType").in(filter.getGpuTypesId()));
		}
	}

	private void findByGoodMemory(Root<Models> root, CriteriaQuery<?> query) {
		if (!filter.getMemoriesId().isEmpty()) {
			predicates.add(root.get("memoryType").in(filter.getMemoriesId()));
		}
	}

	private void findByNvidia(Root<Models> root, CriteriaQuery<?> query) {
		if (!filter.getNvidiaTypeId().isEmpty()) {
			predicates.add(root.get("nvidiaType").in(filter.getNvidiaTypeId()));
		}
	}

	private void findByScrean(Root<Models> root, CriteriaQuery<?> query) {
		if (!filter.getScreanTypeId().isEmpty()) {
			predicates.add(root.get("screanType").in(filter.getScreanTypeId()));
		}
	}

	private void findByGoodProcc(Root<Models> root, CriteriaQuery<?> query) {
		if (!filter.getProccTypesId().isEmpty()) {
			predicates.add(root.get("proccType").in(filter.getProccTypesId()));
		}
	}

	private void findByGoodRam(Root<Models> root, CriteriaQuery<?> query) {
		if (!filter.getRamTypesId().isEmpty()) {
			predicates.add(root.get("ramType").in(filter.getRamTypesId()));
		}
	}

	private void fetch(Root<Models> root, CriteriaQuery<?> query) {
		if (!query.getResultType().equals(Long.class)) {
			query.distinct(true);
			root.fetch("goodType");
			root.fetch("color");
			root.fetch("gpuType");
			root.fetch("memoryType");
			root.fetch("nvidiaType");
			root.fetch("screanType");
			root.fetch("proccType");
			root.fetch("ramType");

		}
	}

	@Override
	public Predicate toPredicate(Root<Models> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		fetch(root, query);
		findByPrice(root, query, cb);
		findByType(root, query);
		findByGoodCountry(root, query);
		findByGoodGPU(root, query);
		findByGoodMemory(root, query);

		findByNvidia(root, query);
		findByScrean(root, query);

		findByGoodProcc(root, query);
		findByGoodRam(root, query);
		findByModelName(root, query, cb);

		if (predicates.isEmpty())
			return null;
		Predicate[] array = new Predicate[predicates.size()];
		array = predicates.toArray(array);
		return cb.and(array);
	}

}

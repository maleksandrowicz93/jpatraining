package pl.com.bottega.jpatraining.associations;

import javax.persistence.EntityManager;

public class AddProductToOrder {

    private final EntityManager em;

    public AddProductToOrder(EntityManager em) {
        this.em = em;
    }

    public void add(Long orderId, Long productId, Integer count) {
        LineItem lineItem = new LineItem(
            em.getReference(Order.class, orderId),
            em.getReference(Product.class, productId),
            count
        );
        em.persist(lineItem);
    }

}

package Hello.core.discount;

import Hello.core.member.Member;

public interface DiscountPolicy {
    /*
     * @return discount price
     */
    int discount(Member member, int price);


}

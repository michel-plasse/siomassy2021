package fr.siomassy2021.dao;

import fr.siomassy2021.model.Canal;
import java.util.ArrayList;
import java.util.List;

public class CanalDao {

  public static List<Canal> getByMemberId(int memberId) {
    // Le résultat est toujours appelé result
    List<Canal> result = new ArrayList<Canal>();
    // Les canaux d'abord mis en dur
    result.add(new Canal(1, "BTS SIO 2021"));
    result.add(new Canal(1, "CDA 2021"));
    return result;
  }
}

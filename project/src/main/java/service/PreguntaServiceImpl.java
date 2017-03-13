package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import domain.Pregunta;
import domain.Trabajo;

@Service
public class PreguntaServiceImpl {

    private List<Pregunta> preguntas;
    private List<Trabajo> trabajos;
    private List<String> respuestas;
    private String name; 
    private String trabajoID;
    public PreguntaServiceImpl() {
                preguntas = new ArrayList<Pregunta>();
                respuestas = new ArrayList<String>();
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("UnidadCurso");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Pregunta> consulta = em.createQuery(
                "select a from Pregunta a ", Pregunta.class);
        for (Pregunta p : consulta.getResultList()) {
            System.out.println(p.getTexto());
                        preguntas.add(p);
                        respuestas.add("");
        }
        em.close();
     }

     public List<Trabajo> TrabajoServiceImpl() {
                trabajos = new ArrayList<Trabajo>();
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("UnidadCurso");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Trabajo> consulta = em.createQuery(
                "select t from Trabajo t ", Trabajo.class);
        for (Trabajo tr : consulta.getResultList()) {
            System.out.println(tr.getTrabajoID());
                        trabajos.add(tr);
        }
        em.close();
        return trabajos;
     }
    
    public void setName(String name) {
       this.name=name;
    }
    public String getName() {
      return name;
    }
    public void setTrabajoID(String trabajoID) {
       this.trabajoID=trabajoID;
    }
    public String getTrabajoID() {
      return trabajoID;
    }
    public List<String> getRespuestas() {
        return respuestas;
    }
    public List<Pregunta> getPreguntas() {
        return preguntas;
    }
    public Pregunta getPregunta(int id) {
        if(id <= preguntas.size()) {
          return preguntas.get(id-1);
        }
        return null;
    }

    public void setRespuesta(int i, String resp) {
       respuestas.set((i-1),resp);
    }
}
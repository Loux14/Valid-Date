//  Loux14

//  NB : l"utilisation du double \n dans mes prints 
//  a pour but de rendre l'utilisation plus lisible dans le terminal

import java.util.Scanner;

public class ValideDate {
     public static void main(String[] args) {


          Scanner lecteur = new Scanner(System.in);


          // Demande l'année 
          System.out.println("\nEntre l'année: ");
          int annee = lecteur.nextInt();

          //Vérifie que l'année est entre 1900 et 2030
          while (annee < 1900 || annee > 2030) {
               System.err.println("Année invalide; doit être entre 1900 et 2030\n");
               System.out.println("Entre l'année: ");
               annee = lecteur.nextInt();
          }


          //Vérifie année bissextile
          boolean bissextile;

          if (annee %4 == 0 && annee %100 != 0)
               bissextile = true;
          else if (annee %400 == 0)
               bissextile = true;
          else
               bissextile = false;


          
          // Demande le mois 
          System.out.println("\nEntre l'entier correspondant au mois (1-12): ");
          int mois = lecteur.nextInt();

          //Vérifie mois entre 1 et 12
          while (mois < 1 || mois > 12) {
          System.err.println("Mois invalide; doit être entre 1900 et 2030\n");
          System.out.println("Entre l'entier correspondant au mois (1-12): ");
          mois = lecteur.nextInt();
          }



          // Limiter le nombre de jour selon le mois choisi
          int jourMax = switch (mois){
               case 1,3,5,7,8,10,12 -> 31;
               case 4,6,9,11 -> 30;
               default -> 0;
          };



          //Cas spécial pour février
          if (mois == 2){
               if (bissextile == true)
                    jourMax = 29;
               else
                    jourMax = 28;
          };

          

          // Demande le jour
          System.out.println("\nEntre l'entier correspondant au jour: ");
          int jour = lecteur.nextInt();

          //Vérifie jour entre 1 et le maximum
          while (jour < 1 || jour > jourMax) {
          System.err.printf("Jour invalide; doit être entre 1 et %d\n\n", jourMax);
          System.out.println("Entre l'entier correspondant au jour: ");
          jour = lecteur.nextInt();
          }



          // Donne le résultat
          System.out.printf("\n%d/%d/%d est une date valide!\n\n", jour, mois, annee);


          lecteur.close();
     }
    
}


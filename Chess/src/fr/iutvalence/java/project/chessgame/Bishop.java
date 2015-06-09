package fr.iutvalence.java.project.chessgame;


import java.util.ArrayList;
import java.util.List;


/**
 * Une pièce de fou
 */
public class Bishop extends AbstractPiece
{
      /**
       * Valeur de la coordonnée de la pièce
       */
      private int position = 1;

      /**
       * La liste des différentes positions possible terme de coordonnées
       */
      private final int[][] listPosition = { { position, position }, { position, -position }, { -position, -position },
                  { -position, position } };

      /**
       * Créer un fou de couleur donnée
       *
       * @param couleur La couleur du fou
       */
      public Bishop(ColorEnum couleur)
      {
            super(couleur);
            this.Piecetype = PieceType.BISHOP;
            if (couleur == ColorEnum.BLACK)
            {
                  this.PieceName = ListPieces.BLACK_BISHOP;
            }
            else
            {
                  this.PieceName = ListPieces.WHITE_BISHOP;
            }
      }

      /**
       * Détermine les différents movements possible à partir d'une position de
       * départ donnée
       *
       * @param positionDepart La position actuelle de la pièce
       * @return Une liste de tout les déplacements possible à partir d'une
       *         position
       */
      @Override
      public List<Position> possibleMovements(Position positionDepart)
      {
            List<Position> possibleMovement = new ArrayList<Position>();
            Square positionDeFin;
            Position newPosition;
            int i, j;
            for (int[] direction : listPosition)
            {
                  for (int compteurDirection = 1; compteurDirection < 8; compteurDirection++)
                  {
                        i = positionDepart.obtenirNumeroDeLigne() + direction[0] * compteurDirection;
                        j = positionDepart.obtenirNumeroDeColonne() + direction[1] * compteurDirection;
                        if (i >= 0 && i < Echiquier.NOMBRE_DE_LIGNES && j < Echiquier.NOMBRE_DE_COLONNES && j >= 0)
                        {
                              positionDeFin = Echiquier.square.get(newPosition = new Position(i, j));
                              if (positionDeFin.getPiece() != null)
                              {
                                    if (positionDeFin.getPiece().obtenirCouleur() == this.couleur)
                                    {
                                          break;
                                    }
                                    possibleMovement.add(newPosition);
                                    break;
                              }
                              else
                              {
                                    possibleMovement.add(newPosition);
                              }
                        }
                  }
            }
            return possibleMovement;
      }

      /**
       * @see java.lang.Object#toString()
       */
      @Override
      public String toString()
      {
            return "F" + super.toString();
      }

}

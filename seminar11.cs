
using System.Collections;
using System;
using System.IO;
using System.Text;
using System.Linq;
class Angajat
{
  public string id { get; set; }
  public string name { get; set; }
  public Nivel nivel { get; set; }
  public double venitPeOra { get; set; }
}

enum Nivel
{
  Junior,
  Mediu,
  Senior
}

class Sarcina
{
  public string id { get; set; }
  public int nrOre { get; set; }
  public Dificultate dificultate { get; set; }
}

enum Dificultate
{
  Usor,
  Mediu,
  Greu
}

class PontajAngajat
{
  public Angajat angajat { get; set; }
  public Sarcina sarcina { get; set; }
  public int luna { get; set; }
  public int nrOreLucrate { get; set; }
}

// 1.Sa se afiseze lista de angajati, grupati dupa nivel: Junior, Mediu, Senior
// fiecarei grupe angajatii se for afisa descrescator dupa venitOra

public void main()
{

}

public void groupAngajati(IEnumerable<Angajat> angajati)
{
  var lista = from angajat in angajati
              group angajat by angajat.nivel;
  foreach(var a in lista)
  {
    Console.WriteLine(a.key);
    foreach (var b in a.OrderByDescending(x => x.venitPeOra)) {
      Console.WriteLine(b);
    }
  }
}

// 2. Sa se scrie cate ore dureaza in medie fiecare tip de sarcina

 public void averageTime(IEnumerable<Sarcina> sarcini)
{
  var groups = from s in sarcini
               group s by s.Dificultate into g
               select new
               {
                 dificultate = g.key.Dificultate,
                 average = g.Average(t => t.nrOre)
               };
  foreach(var a in groups)
  {
    Console.WriteLine($"{a.dificultate} {a.medie}");
  }
}

// 3. Sa se afiseze primi 2 cei mai harnici angajati

public void mostMoney(IEnumerable<PontajAngajat> pontaje)
{
  var groups = from p in pontaje
               group p by p.anjagat.name into g
               select new
               {
                 angajat = g.key,
                 harnic = g.Sum(x => x.nrOreLucrate * x.angajat.venitPeOra)
               };
  groups = groups.OrderBy(x => x.harnic).Take(2);
  foreach(var a in groups)
  {
    Console.WriteLine($"{a.angajat} {a.harnic}");
  }
}

// 4.sa se afiseze pentru o anumita luna un raport care sa contina urmatoarele informatii: Nume angajat, nivelul, salariul obtinut in luna respectiva, afisandu-se in ordinea 
// nivelului junior -> senior si crescator per venit

public void monthReport(IEnumerable<Pontaj> pontaje, int lunaCurenta)
{
  var groups = from p in pontaje
               where p.luna = lunaCurenta
               group p by p.angajat.nivel into g
               orderby g.key
               select g;
  foreach(var groupNivel in groups)
  {
    var gr2 = from p in groupNivel
              group p by p.angajat into g
              select new
              {
                angajat = g.key,
                salariu = g.Sum(x => x.nrOreLucrate * x.angajat.venitPeOra)
              };
  foreach(var el in gr2.OrderBy(x.salariu))
    {
      Console.WriteLine($"{el.angajat.name} {el.salariu} {el.angajat.nivel}");
    }
  }
}


delegate T convertFromString<X>(String s);
public class FileRepo<ID, T>
{
  private String filename;
  private convertFromString<T> fromString;

  public FileRepo(String fname, convertFromString convert)
  {
    filename = fname;
    fromString = convert;
  }

  private void readFromFile()
  {
    using(TextReader reader = File.OpenText(filename))
    {
      while (line = reader.ReadLine())
        base.save(fromString(line));
    }
  }
}